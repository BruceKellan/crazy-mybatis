package top.brucekellan.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.brucekellan.model.User;

import java.util.List;

/**
 * @author brucekellan
 */
@Mapper
public interface UserMapper {

    List<User> listAll();

}