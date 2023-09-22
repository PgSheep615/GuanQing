package task;

import Pojo.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class guanQingManage {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/liao?useSSL=false&useServerPrepStmts=true";
        String user = "root";
        String password = "wyx06151";

        //创建连接
        Connection conn = DriverManager.getConnection(url, user, password);

        String id = "";
        String name = "";
        String stuId = "";
        String post = "";
        String college = "";
        String email = "";
        String phone = "";

        //增加
        /*addMember(conn, "超人强", "2023123123", "技术组组长",
                "计算机学院计科一班", "123@qq.com", "12345678901");

        addMember(conn, "GG bond", "2023123124", "技术组后端开发",
                "电智学院电气一班", "456@qq.com", "13237189281");

        addMember(conn, "波比", "2023123125", "技术组组长",
                "计算机学院计科一班", "789@qq.com", "13678935612");

        addMember(conn, "lzb", "2022414130", "技术组后端开发",
                "网工1班", "2663058456@qq.com", "13688888888");

        //删除（学号）
        deleteMember(conn, "2022414130");

        //单个查询（学号）
        queryMember(conn, "2023123123");

        //全部查询（学号）
        queryAllMember(conn);*/

        conn.close();

    }

    //增加成员
    private static boolean addMember(Connection conn, String name, String stuId,
                                     String post, String college, String email, String phone) throws SQLException {
        String sql = "insert into t_member(c_name, c_stu_id, c_post, c_college, c_email, c_phone) value(?, ?, ?, ?, ?, ?);";
        PreparedStatement pstat = conn.prepareStatement(sql);
        String regex1="1\\d{10}";
        String regex2=".+@.+";
        if(!email.matches(regex2)){
            System.out.println("邮箱格式有误！");
        }
        if(!phone.matches(regex1)){
            System.out.println("手机号格式有误！");
            return false;
        }
        try {
            pstat.setString(1, name);
            pstat.setString(2, stuId);
            pstat.setString(3, post);
            pstat.setString(4, college);
            pstat.setString(5, email);
            pstat.setString(6, phone);
            if (pstat.executeUpdate() > 0) {
                pstat.close();
                System.out.println("成员增加成功！");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("增加失败！");
        return false;
    }
    //删除成员（学号）
    private static boolean deleteMember(Connection conn, String stuId) throws SQLException {
        String sql = "DELETE FROM t_member WHERE c_stu_id = ?;";
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, stuId);
            if (pstat.executeUpdate() > 0) {
                System.out.println("删除成功！");
                pstat.close();
                return true;
            }
        System.out.println("查无此学号成员，删除失败！");
        return false;
    }

    //查询单个成员（学号）
    private static boolean queryMember(Connection conn, String stuId) throws SQLException {
        String sql = "SELECT * FROM t_member WHERE c_stu_id = ?";
        PreparedStatement pstat = conn.prepareStatement(sql);
        pstat.setString(1, stuId);
        ResultSet rs = pstat.executeQuery();
        while (rs.next()) {
            System.out.println("学号为"+stuId+"成员查询成功！");
            Member m = getmessage(rs);
            System.out.println(m);
            pstat.close();
            rs.close();
            return true;
        }
        System.out.println("不存在此成员！");
        return false;
    }

    //查询全部成员
    private static boolean queryAllMember(Connection conn) throws SQLException {
        String sql = "SELECT * FROM t_member ;";
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        List<Member> list = new ArrayList<>();
        while (rs.next()) {
            Member m = getmessage(rs);
            list.add(m);
        }
        if (list.size() > 0) {
            for (Member m : list) {
                System.out.println(m);
            }
            rs.close();
            return true;
        } else {
            System.out.println("无任何成员！");
            return false;
        }
    }

    //从数据源读取数据，返回成员类
    private static Member getmessage(ResultSet rs) throws SQLException {
        String c_id = rs.getString("c_id");
        Integer id = Integer.parseInt(c_id);
        String stuId = rs.getString("c_stu_id");
        String name = rs.getString("c_name");
        String post = rs.getString("c_post");
        String college = rs.getString("c_college");
        String email = rs.getString("c_email");
        String phone = rs.getString("c_phone");
        Member m = new Member(id, name, stuId, post, college, email, phone);
        return m;
    }
}


