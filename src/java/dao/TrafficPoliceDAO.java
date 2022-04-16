package dao;

import db.DBConnector;
import dto.TrafficPoliceDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TrafficPoliceDAO {
    
    
    DBConnector db=new DBConnector();
    Statement st=db.getStatement();
    ResultSet rs=null;
    
    public TrafficPoliceDTO getTrafficPoliceData(String userid)
    {
        TrafficPoliceDTO police=new TrafficPoliceDTO();
        String query="select * from demo_traffic_police where police_id='"+userid+"'";
        
        try
        {
            ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                police.setName(rs.getString("name"));
                police.setEmail(rs.getString("email"));
                police.setDob(rs.getString("dob"));
                police.setZone(rs.getString("zone"));
                police.setContact(rs.getString("contact"));
                police.setAddress(rs.getString("address"));
                police.setAadharno(rs.getString("aadhar_no"));
                police.setUserid(rs.getString("police_id"));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
      return police;
    }
}
