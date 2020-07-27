package cn.jihui.ssm.bloom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class BloomFilterService {
    private    BloomFilter<Integer> filter;

    /**
     * @PostConstruct 程序启动时候加载
     */
    @PostConstruct
    public void initBloomFilter() {
        // 获取key
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> list = Arrays.asList(arr);
        if (!CollectionUtils.isEmpty(list)) {
            // 默认误码率3%
            filter = BloomFilter.create(Funnels.integerFunnel(), list.size());
            for (Integer num : list) {
                filter.put(num);
            }
        }
    }


    public boolean numIsExist(Integer num){
        return filter.mightContain(num);
    }

}
