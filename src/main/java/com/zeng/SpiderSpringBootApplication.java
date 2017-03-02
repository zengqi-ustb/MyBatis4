package com.zeng;

import com.zeng.domain.Goods;
import org.apache.ibatis.session.SqlSession;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpiderSpringBootApplication implements CommandLineRunner {

	private final SqlSession sqlSession;

	public SpiderSpringBootApplication(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpiderSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
		List<Goods> list = new ArrayList<>();
        System.out.println("测试有值");
        list = mapper.selectGoods(1,6,"baidu","success");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        list.clear();
		System.out.println("测试平台");
		list = mapper.selectGoods(1,6,"taobao",null);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
        list.clear();
		System.out.println("测试type");
		list = mapper.selectGoods(1,6,null,"success");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
        list.clear();
        System.out.println("测试无值");
        list = mapper.selectGoods(1,6,"error","error");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        list.clear();
        System.out.println("测试无值后是否正常运行");
        list = mapper.selectGoods(1,6,"baidu","success");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
	}
}