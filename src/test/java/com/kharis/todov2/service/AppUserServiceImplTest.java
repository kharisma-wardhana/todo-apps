package com.kharis.todov2.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kharis.todov2.model.AppUser;
import com.kharis.todov2.repository.AppUserRepo;
import com.kharis.todov2.service.Impl.AppUserServiceImpl;

@DisplayName("AppUserService Test")
@ExtendWith(MockitoExtension.class)
public class AppUserServiceImplTest {
  @Mock
  private AppUserRepo appUserRepo;

  @InjectMocks
  private AppUserServiceImpl appUserService;

  private AppUser appUser;

  @BeforeEach
  public void setUp() {
    appUser = AppUser.builder()
        .id(1L)
        .fullname("KharismaWardhana")
        .username("kharis")
        .email("kharisma.wardhana@spesolution.com")
        .password("123456")
        .build();
  }

  @Test
  public void testSuccessLogin() {
    Mockito.when(appUserRepo.findByUsernameAndPassword("kharis", "123456"))
        .thenReturn(Optional.of(appUser));
    Optional<AppUser> appUserDetails = appUserService.signIn("kharis", "123456");
    assertEquals(appUserDetails.get().getId(), 1L);
  }

  @Test
  public void testFailLogin() {
    Mockito.when(appUserRepo.findByUsernameAndPassword("kharis", "12345678"))
        .thenReturn(Optional.empty());
    Optional<AppUser> appUserDetails = appUserService.signIn("kharis", "12345678");
    assertEquals(appUserDetails.isPresent(), false);
  }

}
