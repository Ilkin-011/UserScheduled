package com.atl.users.service;

import com.atl.users.dao.entity.UsersEntity;
import com.atl.users.dao.repository.UsersRepository;
import com.atl.users.util.Gender;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository repository;
    @Scheduled(fixedDelay = 3000)
    @Scheduled(cron = "44 15 11 3 * *")
    public void happy(){
        LocalDate localDate=LocalDate.now();
        List<UsersEntity>usersEntities=repository.findAll();
        for (UsersEntity entity: usersEntities){
            if (entity.getBirthDay() !=null){
                if(entity.getBirthDay().getMonth()==localDate.getMonth()&&
                        entity.getBirthDay().getDayOfMonth()==localDate.getDayOfMonth()){
                    var gender = entity.getGender() == Gender.MALE? "bey":"xanim";




                    String RED = "\u001B[31m";
                    String GREEN = "\u001B[32m";
                    String BLUE = "\u001B[34m";
                    String RESET = "\u001B[0m";

                    System.out.println(RED + "***************************************" + RESET);
                    System.out.println(BLUE + "🎉 TƏBRİKLƏR " + GREEN + entity.getName() + " " + gender + "🎉!" + RESET);
                    System.out.println(BLUE + "🎂 dogum gununuz mubarek)))))! 🎂" + RESET);
                    System.out.println(RED + "***************************************" + RESET);

                }
            }
        }
    }
}

