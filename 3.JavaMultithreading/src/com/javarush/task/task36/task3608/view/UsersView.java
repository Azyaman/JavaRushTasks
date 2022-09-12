package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

import java.util.ArrayList;
import java.util.List;

public class UsersView implements View {
    private Controller controller;


    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void refresh(ModelData modelData) {
        List<User> userArrayList = new ArrayList<>(modelData.getUsers());
        if (!modelData.isDisplayDeletedUserList()) {
            System.out.println("All users:");
        } else {
            System.out.println("All deleted users:");
        }
        for (User user: userArrayList) { System.out.println( "\t" + user.toString()); }
        System.out.println("===================================================");
    }

    public void fireEventShowAllUsers() {controller.onShowAllUsers(); }

    public void fireEventShowDeletedUsers() {controller.onShowAllDeletedUsers(); }

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }


}
