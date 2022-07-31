package com.kharis.todov2.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;

import com.kharis.todov2.model.AppUser;

@DisplayName("AppUserRepo Test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AppUserRepoTest {
  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private AppUserRepo appUserRepo;

  private AppUser appUser;

  @BeforeEach
  public void setUp() {
    appUser = AppUser.builder()
        .fullname("KharismaWardhana")
        .username("kharis")
        .email("kharisma.wardhana@spesolution.com")
        .build();
  }

  @Test
  public void testInjectedComponentsAreNotNull() {
    assertNotNull(entityManager);
    assertNotNull(appUserRepo);
  }

  @Test
  public void testShouldReturnEmptyIfTableIsEmpty() {
    Assertions.assertThat(appUserRepo.findAll()).isEmpty();
  }

  @Test
  public void testFindDataByUsernameOrEmail() {
    AppUser user = appUser;
    entityManager.persist(user);
    Assertions.assertThat(appUserRepo.findByUsername("kharis").get().getId()).isNotNull();
    Assertions.assertThat(appUserRepo.findByEmail("kharisma.wardhana@spesolution.com").get().getId()).isNotNull();
    Assertions.assertThat(
        appUserRepo.findByUsernameOrEmail(
            "kharis",
            "kharisma.wardhana@spesolution.com").get().getId())
        .isNotNull();
  }

  @Test
  public void testUserNotFound() {
    AppUser testUser = appUser;
    entityManager.persist(testUser);
    Assertions.assertThat(appUserRepo.findByUsername("karis")).isEmpty();
    Assertions.assertThat(appUserRepo.findByEmail("kharis@test.com")).isEmpty();
    Assertions.assertThat(appUserRepo.findByUsernameOrEmail("karis", "karis@test.com")).isEmpty();
  }

  @Test
  @Sql("/user-test.sql")
  public void testFindAllUserData() {
    Assertions.assertThat(appUserRepo.findAll()).hasSize(2);
  }
}
