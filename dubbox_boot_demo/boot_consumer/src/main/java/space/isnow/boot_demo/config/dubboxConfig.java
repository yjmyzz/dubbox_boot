package space.isnow.boot_demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by lxq on 15-11-17.
 */
@Configuration
@ImportResource("classpath:dubbo_consumer.xml")
public class dubboxConfig {
}
