package com.example.myapplication.utils;

public class UrlUtils {

    public static  final String App_Register_Url="https://hd215.api.yesapi.cn/?s=App.Table.Create&model_name=Peter&data=%7B%22username%22%3A%22赵云%22%2C%22mobilenumber%22%3A%22176990030092%22%7D&app_key=CD0FD909500176B1D464830847C96DDA&sign=32EA1778D32ADE7E8E396FD4D832FFF1";

    public static  final String App_Login_Url="https://hd215.api.yesapi.cn/?s=App.Table.Create&model_name=Peter&data=%7B%22username%22%3A%22赵云%22%2C%22mobilenumber%22%3A%22176990030092%22%7D&app_key=CD0FD909500176B1D464830847C96DDA&sign=32EA1778D32ADE7E8E396FD4D832FFF1";
    public static  final String App_Get_MyProject_list="https://hd215.api.yesapi.cn/?s=App.Table.FreeQuery&return_data=0&model_name=Peter&logic=and&where=%5B%5B%22id%22%2C+%22%3E%3D%22%2C+%221%22%5D%5D&order=%5B%22add_time+DESC%22%5D&page=1&perpage=10&is_real_total=1&app_key=CD0FD909500176B1D464830847C96DDA&sign=7C46F5A412421BC13F8F24048AAE3E30";

    public static  final String App_Get_Info_list="https://hd215.api.yesapi.cn/?s=App.Table.FreeQuery&return_data=0&model_name=tginfolist&logic=and&where=%5B%5B%22id%22%2C+%22%3E%3D%22%2C+%221%22%5D%5D&order=%5B%22add_time+DESC%22%5D&page=1&perpage=10&is_real_total=1&app_key=CD0FD909500176B1D464830847C96DDA&sign=DCD6D58DEE712F48B416628A8895E925";

    public static  final String App_Commit_InFor="https://hd215.api.yesapi.cn/?&s=App.Table.Create&return_data=0&model_name=Peter&data={\"username\":\"李德华\",\"mobilenumber\":\"19210030098\",\"projecttype\":\"ETC办理\"}&app_key=CD0FD909500176B1D464830847C96DDA&sign=C82C8C4E496F8BB151A0ECEDDE383F9D";

    public static String  createUrlInfor(String userName,String number,String projecttype){
        return"https://hd215.api.yesapi.cn/?&s=App.Table.Create&return_data=0&model_name=Peter&data={\"username\":\"" +
                userName +
                "\",\"mobilenumber\":\"" +
                number +
                "\",\"projecttype\":\"" +
                projecttype +
                "\"}&app_key=CD0FD909500176B1D464830847C96DDA&sign=C82C8C4E496F8BB151A0ECEDDE383F9D";
    }

}
