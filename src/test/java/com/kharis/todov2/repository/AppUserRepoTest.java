package com.kharis.todov2.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        .password("password")
        .isActive(true)
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
    entityManager.persist(appUser);
    Assertions.assertThat(appUserRepo.findByUsername("kharis").get().getId()).isNotNull();
    Assertions.assertThat(appUserRepo.findByEmail("kharisma.wardhana@spesolution.com").get().getId()).isNotNull();
    Assertions.assertThat(
        appUserRepo.findByUsernameOrEmail(
            "kharis",
            "kharisma.wardhana@spesolution.com").get().getId())
        .isNotNull();
    assertEquals(appUserRepo.findByUsername("kharis").get().getId(), 1L);
    assertEquals(appUserRepo.findByEmail("kharisma.wardhana@spesolution.com").get().getId(), 1L);
    assertEquals(
        appUserRepo.findByUsernameOrEmail(
            "karis",
            "kharisma.wardhana@spesolution.com").get().getId(),
        1L);
  }

  @Test
  public void testUserNotFound() {
    entityManager.persist(appUser);
    Assertions.assertThat(appUserRepo.findByUsername("karis")).isEmpty();
    Assertions.assertThat(appUserRepo.findByEmail("kharis@test.com")).isEmpty();
    Assertions.assertThat(appUserRepo.findByUsernameOrEmail("karis", "karis@test.com")).isEmpty();
    Assertions.assertThat(appUserRepo.findByUsernameAndPassword("karis", "password")).isEmpty();
    Assertions.assertThat(appUserRepo.findByEmailAndPassword("karis@test.com", "password")).isEmpty();
    Assertions.assertThat(appUserRepo.findByIsActive(false)).isEmpty();
  }

  @Test
  @Sql("/user-test.sql")
  public void testFindAllUserData() {
    Assertions.assertThat(appUserRepo.findAll()).hasSize(2);
  }

  @Test
  public void testFindByUsernameAndPassword() {
    entityManager.persist(appUser);
    Assertions.assertThat(appUserRepo.findByUsernameAndPassword(
        "kharis",
        "password"))
        .isNotEmpty();

    Assertions.assertThat(appUserRepo.findByUsernameAndPassword(
        "kharis",
        "password2").isEmpty());
  }

  @Test
  @Sql("/user-test.sql")
  public void testFindUserRole() {
    // Assertions.assertThat(appUserRepo.findByRole("ADMIN")).isNotEmpty();
    // Assertions.assertThat(appUserRepo.findByRole("USER")).isNotEmpty();
    // Assertions.assertThat(appUserRepo.findByRole("ADMIN").get().getId()).isNotNull();
    // Assertions.assertThat(appUserRepo.findByRole("USER").get().getId()).isNotNull();
  }

  @Test
  @Sql("/user-test.sql")
  public void testFindLatestUpdatedUser() {
    assertNotNull(appUserRepo.getLatestUpdatedUser());
    assertEquals(
        "admin",
        appUserRepo.getLatestUpdatedUser().stream().findFirst().get().getUsername());
    assertEquals(
        "jdoe",
        appUserRepo.getLatestUpdatedUser().stream().skip(1).findFirst().get().getUsername());
  }
}
