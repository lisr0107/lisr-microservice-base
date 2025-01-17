package lisr.kis.base.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Hello world!
 *
 */
@EnableConfigServer
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigCenterApp 
{
    public static void main( String[] args )
    {  
        SpringApplication.run(ConfigCenterApp.class, args);
    }
}
