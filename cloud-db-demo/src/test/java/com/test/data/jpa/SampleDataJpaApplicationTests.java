//package com.test.data.jpa;
//
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = SampleDataJpaApplication.class)
//@WebAppConfiguration
//@ActiveProfiles("scratch")
//// Separate profile for web tests to avoid clashing databases
//public class SampleDataJpaApplicationTests {
//
//	@Autowired
//	private WebApplicationContext context;
//
//	private MockMvc mvc;
//
//	@Before
//	public void setUp() {
//		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
//	}
//
//	@Test
//	public void testHome() throws Exception {
//
//		this.mvc.perform(get("/")).andExpect(status().isOk())
//				.andExpect(content().string("Bath"));
//	}
//}
