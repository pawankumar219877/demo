package com.example.demo.mapper;

import com.example.demo.builder.PermutationBuilder;
import com.example.demo.model.PermutationModel;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PermutationMapper implements ResultSetExtractor {
    @Override
    public List<PermutationModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<PermutationModel> li= new ArrayList<>();
        while(rs.next()){
            li.add(new  PermutationBuilder().withId(rs.getLong("id"))
                    .withPerrmutes(rs.getString("perrmutes")).build()) ;
        }

        return li;
    }
}
