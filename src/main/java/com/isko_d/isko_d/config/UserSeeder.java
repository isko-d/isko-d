package com.isko_d.isko_d.config;

import com.isko_d.isko_d.model.User;
import com.isko_d.isko_d.exception.NotFoundException;
import com.isko_d.isko_d.model.Role;
import com.isko_d.isko_d.repository.UserRepository;
import com.isko_d.isko_d.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Configuration
public class UserSeeder {

    @Bean
    @Transactional
    @Order(2)
    CommandLineRunner seedUsers(UserRepository userRepository, RoleRepository roleRepository) {
        return args -> {
            // Only seed if the table is empty to avoid duplicates
            if (userRepository.count() == 0) {
                Role superAdminRole = roleRepository.findByName("superadmin")
                                        .orElseThrow(() -> new NotFoundException(Role.class, "superadmin", "name"));
                // Force initialize role
                User superAdminUser = new User("Super", "", "Admin", "superadmin@iskod.com", "qyL2jVlerK8rzu8Ey");
                superAdminUser.getRoles().add(superAdminRole);
                userRepository.save(superAdminUser);
            } else {
                System.out.println("UserSeeder: Users already exist. Skipping seed.");
            }
        };
    }
}
