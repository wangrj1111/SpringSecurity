package wang.mapper;

import org.apache.ibatis.annotations.Mapper;
import wang.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-11-14
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
