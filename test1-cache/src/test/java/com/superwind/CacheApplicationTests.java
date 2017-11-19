package com.superwind;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheApplicationTests {

	@Autowired
	RedisTemplate redisTemplate;
	@Test
	public void contextLoads() {

		Set<String> set1=new HashSet<String>();
		set1.add("set1");
		set1.add("set2");
		set1.add("set3");
		redisTemplate.opsForSet().add("set1",set1);
		Set<String> resultSet =redisTemplate.opsForSet().members("set1");
		System.out.println("resultSet:"+resultSet);

		Map<String,String> map=new HashMap<String,String>();
		map.put("key1","value1");
		map.put("key2","value2");
		map.put("key3","value3");
		map.put("key4","value4");
		map.put("key5","value5");
		redisTemplate.opsForHash().putAll("map1",map);
		Map<String,String> resultMap= redisTemplate.opsForHash().entries("map1");
		List<String> reslutMapList=redisTemplate.opsForHash().values("map1");
		Set<String>resultMapSet=redisTemplate.opsForHash().keys("map1");
		String value=(String)redisTemplate.opsForHash().get("map1","key1");
		System.out.println("value:"+value);
		System.out.println("resultMapSet:"+resultMapSet);
		System.out.println("resultMap:"+resultMap);
		System.out.println("resulreslutMapListtMap:"+reslutMapList);

		List<String> list1=new ArrayList<String>();
		list1.add("a1");
		list1.add("a2");
		list1.add("a3");

		List<String> list2=new ArrayList<String>();
		list2.add("b1");
		list2.add("b2");
		list2.add("b3");
		redisTemplate.opsForList().leftPush("listkey1",list1);
		redisTemplate.opsForList().rightPush("listkey2",list2);
		List<String> resultList1=(List<String>)redisTemplate.opsForList().leftPop("listkey1");
		List<String> resultList2=(List<String>)redisTemplate.opsForList().rightPop("listkey2");
		System.out.println("resultList1:"+resultList1);
		System.out.println("resultList2:"+resultList2);

	}

}
