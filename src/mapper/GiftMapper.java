package mapper;

import gift.Gift;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GiftMapper {
    public static Gift mapToGift(ResultSet rs) throws SQLException {
        return new Gift(
                rs.getInt("GiftID"),
                rs.getString("GiftName"),
                rs.getDouble("TotalWeight")
        );
    }
}
