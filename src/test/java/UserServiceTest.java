import com.bugraburunguz.leavemanagementservice.entity.UserEntity;
import com.bugraburunguz.leavemanagementservice.repository.UserAdminRepository;
import com.bugraburunguz.leavemanagementservice.request.UserRequest;
import com.bugraburunguz.leavemanagementservice.response.UserResponse;
import com.bugraburunguz.leavemanagementservice.util.DateUtil;
import com.bugraburunguz.leavemanagementservice.validation.impl.UserAdminServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserAdminServiceImpl userAdminService;
    @Mock
    private UserAdminRepository userAdminRepository;

    @Test
    void should_create_user() {
        UserRequest userRequest = new UserRequest();
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName("Buğra");
        userEntity.setLastName("Bürüngüz");
        userEntity.setDateOfRecruitment(LocalDate.parse("2022-08-09"));
        userEntity.setRole("Java Developer");
        userEntity.setRightOfLeaveDay(DateUtil.calculateRightOfLeavesDay(LocalDate.parse("2022-08-09")));

        given(userAdminRepository.save(any(UserEntity.class))).willReturn(userEntity);

        userAdminService.create(userRequest);

        ArgumentCaptor<UserEntity> userEntityArgumentCaptor = ArgumentCaptor.forClass(UserEntity.class);
        then(userAdminRepository).should(times(1)).save(userEntityArgumentCaptor.capture());
        UserEntity userEntityArgumentCaptorValue = userEntityArgumentCaptor.getValue();
        assertThat(userEntityArgumentCaptorValue.getFirstName()).isEqualTo("Buğra");
        assertThat(userEntityArgumentCaptorValue.getLastName()).isEqualTo("Bürüngüz");
        assertThat(userEntityArgumentCaptorValue.getDateOfRecruitment()).isEqualTo((LocalDate.parse("2022-08-09")));
        assertThat(userEntityArgumentCaptorValue.getRole()).isEqualTo("Java Developer");

    }
}