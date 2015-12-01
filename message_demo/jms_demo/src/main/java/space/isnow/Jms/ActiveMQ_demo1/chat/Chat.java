package space.isnow.Jms.ActiveMQ_demo1.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import javax.naming.InitialContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by lxq on 15-12-1.
 */
public class Chat implements MessageListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(Chat.class);
    private TopicSession pubSession;
    private TopicPublisher publisher;
    private TopicConnection connection;

    private String username;

    //初始化chat
    public Chat(String topicFactory, String topicName, String username) throws Exception{
        //使用jndi.properties文件获取一个JNDI连接
        InitialContext initialContext = new InitialContext();
        //查找一个JMS连接工厂并创建连接
        TopicConnectionFactory connectionFactory = (TopicConnectionFactory)
                initialContext.lookup(topicFactory);
        TopicConnection connection1 = connectionFactory.createTopicConnection();
        //创建２个JMS会话对象
        TopicSession pubSession = connection1.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

        TopicSession subSession = connection1.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        //查找一个topic主题
        Topic chatTopic = (Topic) initialContext.lookup(topicName);
        //创建一个JMS发布者和订阅者
        TopicPublisher publisher = pubSession.createPublisher(chatTopic);

        TopicSubscriber subscriber = subSession.createSubscriber(chatTopic, null, true);
        //设置一个JMS消息侦听器
        subscriber.setMessageListener(this);
        //初识化chat变量
        this.connection = connection;
        this.pubSession = pubSession;
        this.publisher = publisher;
        this.username = username;
        //启动JMS连接
        connection.start();


    }

    //处理来自topicsubscribe的消息
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            LOGGER.debug("message----" + textMessage.getText());

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    //使用发布者发布消息
    protected void writeMessage(String message) throws JMSException{
        TextMessage textMessage = pubSession.createTextMessage();
        textMessage.setText(username + " : " + message);
        publisher.publish(textMessage);
    }
    //关闭JMS连接
    public void close() throws JMSException{
        connection.close();
    }

    public static void main(String[] args){
        if (args.length != 3){
            LOGGER.debug("Factory, top or username　missing");
            try {
                Chat chat = new Chat(args[0], args[1], args[2]);
                BufferedReader commandLine = new BufferedReader(new InputStreamReader(System.in));

                while (true) {
                    String s = commandLine.readLine();
                    if (s.equalsIgnoreCase("exit")){
                        chat.close();
                        System.exit(0);

                    }else {
                        chat.writeMessage(s);

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
