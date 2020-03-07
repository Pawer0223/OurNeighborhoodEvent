## SpringSecurity를 활용하여 PW암호화를 적용 시킬수 있다.

### PasswordEncoder인터페이스를 활용하여, 암호화(encode) 및 암호화된 PW확인(matches)이 가능하다.

- 암호화 작업시 자료형을 PasswordEncoder로 선언한다.

```
public class CustomAuthenticationProvider implements AuthenticationProvider {

  @Autowired
  private PasswordEncoder passwordEncoder;

...
  
```

- PasswordEncoder에 사용 될 암호화 클래스는 Xml에 정의하여 유연하게 관리할 수 있다. ( context-security.xml )

```
<beans:bean id="passwordEncoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder"/> 
```

### 결과

- DB의 암호화된 PW <-> 입력PW의 비교를 matches함수를 사용함으로써 가능하다.
