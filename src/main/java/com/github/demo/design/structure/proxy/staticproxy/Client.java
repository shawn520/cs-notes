package com.github.demo.design.structure.proxy.staticproxy;

/**
 * @author Shawn
 * @date 2019/10/12
 */
public class Client {
    public static void main(String[] args) {
        ITeacherDao teacherDao = new TeacherDao();
        ITeacherDao teacherDaoProxy = new TeacherDaoProxy(teacherDao);
        teacherDaoProxy.teach();

    }
}
