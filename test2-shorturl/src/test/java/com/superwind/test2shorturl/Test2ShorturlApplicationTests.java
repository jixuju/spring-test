package com.superwind.test2shorturl;

import com.superwind.test2shorturl.service.ShortURL;
import com.superwind.test2shorturl.service.ShortURL2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test2ShorturlApplicationTests {

	@Test
	public void testShortUrl() {
		String shortUrl = ShortURL.encode(931468251920068608L);
		System.out.println("shortUrl encode: " + shortUrl);
		System.out.println("shortUrl decode: " + ShortURL.decode(shortUrl));
	}

	@Test
	public void testShortUrl2() {
		String shortUrl = ShortURL2.encode(931468251920068608L);
		System.out.println("shortUrl2 encode: " + shortUrl);
		System.out.println("shortUrl2 decode: " + ShortURL2.decode(shortUrl));
	}
}
