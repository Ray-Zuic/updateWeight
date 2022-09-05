package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ServerWeight
 * @Description TODO
 * @Author chenhao_gao
 * @Date 2022/9/5 18:53
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServerWeight {
    private String url;
    private String weight;
}
