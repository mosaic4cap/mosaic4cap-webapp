package de.mosaic4cap.webapp.restservice.dao.impl;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.mosaic4cap.webapp.Application;
import de.mosaic4cap.webapp.helper.Person;
import de.mosaic4cap.webapp.helper.PersonDao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.core.Is.is;

/**
 * Created by svenklemmer on 25.09.14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class HibernateDaoTest {
  private static final Logger LOGGER = Logger.getLogger(HibernateDaoTest.class);

  @Autowired
  private PersonDao dao;

  @Test
  public void testDao() throws Exception {
    Person p1 = new Person("test1");
    Person p2 = new Person("test2");
    Person p3 = new Person("test3");
    Person p4 = new Person("test4");
    Person p5 = new Person("test5");

    //can persist an entitity
    assertThat(dao.create(p1), is(equalTo(p1)));

    //can persist multiple entities
    assertThat(dao.create(p2, p3, p4, p5), hasItems(p2, p3, p4, p5));

    //can modify an entity
    p1.setValue("update1");
    assertThat(dao.merge(p1), is(equalTo(p1)));

    //can modify multiple entities
    p2.setValue("update2");
    p3.setValue("update2");
    p4.setValue("update2");

    assertThat(dao.merge(p2, p3, p4), hasItems(p2, p3, p4));

    //can get an entity by id
    assertThat(dao.retrieve(Long.valueOf(1)), is(equalTo(p1)));

    //can get multiple entitites
    assertThat(dao.retrieveAll().size(), is(greaterThanOrEqualTo(0)));

    //can delete entity
    dao.remove(p1);

    //can delete entity by its id
    p5.setValue("p5");
    Person update = dao.merge(p5);
    dao.removeById(update.getId());
  }
}
