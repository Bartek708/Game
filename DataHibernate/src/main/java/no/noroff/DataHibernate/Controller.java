package no.noroff.DataHibernate;

import no.noroff.DataHibernate.jpa.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @GetMapping(value = "/user")
    public @ResponseBody List<username> userAll() {
        System.out.println("Trying to find all users: ");
        List<username> users = new ArrayList<>();
        for(user usr : DataHibernateApplication.getUser()){
            users.add(new username(usr.getUsername()));
        }
        if (users == null) {
            System.out.println(" --- NO USER FOUND --- ");
        }
        return users;
    }

    @GetMapping(value = "/class")
    public @ResponseBody List<classset> classAll() {
        System.out.println("Trying to find all classes: ");
        List<classset> classes = new ArrayList<>();
        for(classset clss : DataHibernateApplication.getClasses()){
            classes.add(clss);
        }
        if (classes == null) {
            System.out.println(" --- NO CLASS FOUND --- ");
        }
        return classes;
    }


    @GetMapping(value = "/character")
    public @ResponseBody List<chars> charAll() {
        System.out.println("Trying to find all characters: ");
        List<chars> characters = new ArrayList<>();
        for(chars chr : DataHibernateApplication.getCharacter()){
            characters.add(chr);
        }
        if (characters == null) {
            System.out.println(" --- NO CHARACTER FOUND --- ");
        }
        return characters;
    }

    @GetMapping(value = "/ability")
    public @ResponseBody List<abilities> abilitiesAll() {
        System.out.println("Trying to find all abilities: ");
        List<abilities> abilityList = new ArrayList<>();
        for(abilities ability : DataHibernateApplication.getAbilities()){
            abilityList.add(ability);
        }
        if (abilityList == null) {
            System.out.println(" --- NO ABILITY FOUND --- ");
        }
        return abilityList;
    }

    @GetMapping("/character/{ID}")
    public chars charGet(@PathVariable int ID) {
        System.out.println("Trying to find character: " + ID);
        chars returnChar = null;
        for (chars chr : DataHibernateApplication.getCharacter()) {
            if (chr.getId()==(ID)) {
                System.out.println(" --- USER FOUND --- ");
                returnChar = chr;
            }
        }
        if (returnChar == null) {
            System.out.println(" --- USER WAS NOT FOUND --- ");
        }
        return returnChar;
    }

    @GetMapping("/user/{ID}")
    public user userGet(@PathVariable int ID) {
        System.out.println("Trying to find user: " + ID);
        user returnUser = null;
        for (user usr : DataHibernateApplication.getUser()) {
            if (usr.getId()==(ID)) {
                System.out.println(" --- USER FOUND --- ");

                List<chars> characters = new ArrayList<>();
                for(chars chr : DataHibernateApplication.getCharacter()){
                    characters.add(chr);
                }
                returnUser = usr;
            }
        }
        if (returnUser == null) {
            System.out.println(" --- USER WAS NOT FOUND --- ");
        }
        return returnUser;
    }


    @PostMapping("/user")
    public user newUser(@RequestBody user newUser) {

        DataHibernateApplication.addUser(newUser.getUsername(), newUser.getPassword());

        return newUser;
    }

    @PostMapping("/character")
    public chars newChar(@RequestBody chars newChar) {

        DataHibernateApplication.addCharacter(newChar.getName(), newChar.getLevel(),newChar.getUserID(),translator(newChar.getClassID()));
        return newChar;
    }

    @GetMapping("/class/{name:[a-zA-Z]+}")
    public classset classGet(@PathVariable String name) {
        System.out.println("Trying to find user: " + name);
        classset returnClass = null;
        for (classset clss : DataHibernateApplication.getClasses()) {
            if (clss.getName().equalsIgnoreCase(name)) {
                System.out.println(" --- CLASS FOUND --- ");
                returnClass = clss;
            }
        }
        if (returnClass == null) {
            System.out.println(" --- CLASS WAS NOT FOUND --- ");
        }
        return returnClass;
    }

    public String translator(String className){

        if("mage".equals(className.toLowerCase())){
            return 1 + "";
        }else if("hunter".equals(className.toLowerCase())){
            return 2 + "";
        }else if("paladin".equals(className.toLowerCase())){
            return 3 + "";
        }else if("warrior".equals(className.toLowerCase())){
            return 4 + "";
        }else if("warlock".equals(className.toLowerCase())){
            return 5 + "";
        }else if("druid".equals(className.toLowerCase())){
            return 6 + "";
        }

        return 0 + "";
    }
}