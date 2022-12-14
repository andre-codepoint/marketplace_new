package com.finalpro.marketplace;

import com.finalpro.marketplace.model.Product;
import com.finalpro.marketplace.model.User;
import com.finalpro.marketplace.repository.ProductRepository;
import com.finalpro.marketplace.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class MarketplaceApplication {
    private static final Logger log = LoggerFactory.getLogger(MarketplaceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MarketplaceApplication.class, args);
    }

    @Bean
//  @Profile({"dev"})
    public CommandLineRunner createDemo(UserRepository userRepository, ProductRepository productRepository) {
        return (args) -> {
            log.info("Завантаження демо даних у базу");

            // Create users
            // Use https://bcrypt-generator.com/ for Encrypt/Decrypt password/hash

            User user1 = new User("user@gmail.com", "User", "User", "$2a$12$yVVGzK0rZXquvymSY0nDrOH0TBo2WVHOQBDqHBRsxL5IUxkX2bVF.", "USER");
            User user2 = new User("admin@gmail.com", "Admin", "Admin", "$2a$12$yVVGzK0rZXquvymSY0nDrOH0TBo2WVHOQBDqHBRsxL5IUxkX2bVF.", "ADMIN");
            userRepository.save(user1);
            userRepository.save(user2);

            // Create products
            Product product1 = new Product("Диван Kairos Айго 1 ordf Cаванна нова 07 Светло-серый (FM124453)", "Диван АЙГО 1 и 2 от производителя Kairos — мебельное изделие, способное обеспечить необходимый комфорт и сделать помещение более функциональным и стильным.\n" +
                    "\n" + "Для изготовления дивана производителем применяются качественные и безопасные материалы, соответствующие европейским стандартам и требованиями современной мебельной индустрии.\n" +
                    "\n" + "Диван Айго-создаст уют и хорошую атмосферу в Вашем доме.", 8750, "Ukraine, Kharkiv", user1);
            Product product2 = new Product("Apple iPhone 13 Pro", "iPhone 13 Pro Max объединяет мощную систему камер, самый быстрый чип для iPhone A15 Bioniс, емкую батарею с увеличенным рабочим ресурсом, надежную систему безопасности, потрясающий дисплей с частотой обновления до 120 Гц. И все это заключено в прочном корпусе с защитой по стандарту IP68.", 39999, "Ukraine, Lviv", user2);
            Product product3 = new Product("ФУТБОЛКА С ПРИНТОМ BATMAN POP ART", "Привлекательная футболка с необычным изображением Batman в стиле поп-арт. Иллюстратор создал серию портретов героев знаменитых комиксов от компаний Marvel и DC Comics. Футболка изготовлена методом цифровой печати DTG с четким соблюдением технологий. Изображение обладает хорошей стойкостью, насыщенностью красок. Хлопок обладает высокими влагопоглощающими свойствами, в связи с чем не вызывает аллергию. Яркое изделие для тех, кто желает носить эксклюзивную одежду. У нас можно приобрести футболку с принтом, по мотивам комикса компании DC Comics - Бэтмен, не выходя из дома. Если вы хотите удивить и порадовать своих сотрудников или партнеров, клиентов подарком, который будет долгое время дарить приятные эмоции и напоминать о вашем отношении, то футболки с логотипом отличный вариант.", 450, "Ukraine, Kyiv", user1);

            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);
        };
    }

}
