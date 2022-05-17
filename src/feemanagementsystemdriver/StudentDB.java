
package feemanagementsystemdriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDB {
	public static int save(Student s){
            int status=0;
            try{
                Connection con=AccountantDB.getCon();
                PreparedStatement ps=con.prepareStatement("insert into studentinfo(name,email,course,fee,paid,due,address,city,state,country,contactno) values(?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1,s.getName());
                ps.setString(2,s.getEmail());
                ps.setString(3, s.getCourse());
                ps.setInt(4,s.getFee());
                ps.setInt(5,s.getPaid());
                ps.setInt(6,s.getDue());
                ps.setString(7,s.getAddress());
                ps.setString(8,s.getCity());
                ps.setString(9,s.getState());
                ps.setString(10,s.getCountry());
                ps.setString(11,s.getContactno());
                status=ps.executeUpdate();
                con.close();
            }catch(Exception e){System.out.println(e);}
            return status;
	}
	public static int update(Student s){
            int status=0;
            try{
                Connection con=AccountantDB.getCon();
                PreparedStatement ps=con.prepareStatement("update studentinfo set name=?,email=?,course=?,fee=?,paid=?,due=?,address=?,city=?,state=?,country=?,contactno=? where rollno=?");
                ps.setString(1,s.getName());
                ps.setString(2,s.getEmail());
                ps.setString(3, s.getCourse());
                ps.setInt(4,s.getFee());
                ps.setInt(5,s.getPaid());
                ps.setInt(6,s.getDue());
                ps.setString(7,s.getAddress());
                ps.setString(8,s.getCity());
                ps.setString(9,s.getState());
                ps.setString(10,s.getCountry());
                ps.setString(11,s.getContactno());
                ps.setInt(12,s.getRollno());
                status=ps.executeUpdate();
                con.close();
            }catch(Exception e){System.out.println(e);}
            return status;
	}
	public static List<Student> view(){
            List<Student> list=new ArrayList<Student>();
            try{
                Connection con=AccountantDB.getCon();
                PreparedStatement ps=con.prepareStatement("select * from studentinfo");
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    Student s=new Student();
                    s.setRollno(rs.getInt("rollno"));
                    s.setName(rs.getString("name"));
                    s.setEmail(rs.getString("email"));
                    s.setCourse(rs.getString("course"));
                    s.setFee(rs.getInt("fee"));
                    s.setPaid(rs.getInt("paid"));
                    s.setDue(rs.getInt("due"));
                    s.setAddress(rs.getString("address"));
                    s.setCity(rs.getString("city"));
                    s.setState(rs.getString("state"));
                    s.setCountry(rs.getString("country"));
                    s.setContactno(rs.getString("contactno"));
                    list.add(s);
                }
                con.close();
            }catch(Exception e){System.out.println(e);}
            return list;
	}
	public static Student getStudentByRollno(int rollno){
            Student s=new Student();
            try{
                Connection con=AccountantDB.getCon();
                PreparedStatement ps=con.prepareStatement("select * from studentinfo where rollno=?");
                ps.setInt(1,rollno);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    s.setRollno(rs.getInt("rollno"));
                    s.setName(rs.getString("name"));
                    s.setEmail(rs.getString("email"));
                    s.setCourse(rs.getString("course"));
                    s.setFee(rs.getInt("fee"));
                    s.setPaid(rs.getInt("paid"));
                    s.setDue(rs.getInt("due"));
                    s.setAddress(rs.getString("address"));
                    s.setCity(rs.getString("city"));
                    s.setState(rs.getString("state"));
                    s.setCountry(rs.getString("country"));
                    s.setContactno(rs.getString("contactno"));
                }
                con.close();
            }catch(Exception e){System.out.println(e);}
            return s;
	}
	public static List<Student> due(){
            List<Student> list=new ArrayList<Student>();
            try{
                Connection con=AccountantDB.getCon();
                PreparedStatement ps=con.prepareStatement("select * from studentinfo where due>0");
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    Student s=new Student();
                    s.setRollno(rs.getInt("rollno"));
                    s.setName(rs.getString("name"));
                    s.setEmail(rs.getString("email"));
                    s.setCourse(rs.getString("course"));
                    s.setFee(rs.getInt("fee"));
                    s.setPaid(rs.getInt("paid"));
                    s.setDue(rs.getInt("due"));
                    s.setAddress(rs.getString("address"));
                    s.setCity(rs.getString("city"));
                    s.setState(rs.getString("state"));
                    s.setCountry(rs.getString("country"));
                    s.setContactno(rs.getString("contactno"));
                    list.add(s);
                }
                con.close();
            }catch(Exception e){System.out.println(e);}
            return list;
	}
}
