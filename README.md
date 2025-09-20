# Java Study - 자바의 신

Java 기초 및 고급 개념 학습을 위한 프로젝트입니다.

## 📚 학습 목차

1. **Thread (스레드)** - 멀티스레딩과 동기화
   - 기본 Thread 개념
   - Thread vs Runnable
   - Thread 동기화 (Synchronization)
   - Daemon Thread & ThreadLocal

## 📁 프로젝트 구조

```
src/main/java/org/thread/
├── Basic Thread Examples
│   ├── Main.java                    # 기본 Thread 사용법
│   ├── ThreadSample.java           # Thread 클래스 상속 예제
│   ├── RunnableSample.java         # Runnable 인터페이스 구현 예제
│   ├── RunThreads.java             # 여러 스레드 실행 예제
│   ├── NameThread.java             # 스레드 이름 설정 및 관리
│   ├── DemonThread.java            # 데몬 스레드 예제
│   └── ThreadLocal.java            # ThreadLocal 사용법
│
└── Synchronization Examples
    ├── CommonCalculate.java        # synchronized 키워드와 객체 락 예제
    ├── ModifyAmountThread.java     # 멀티스레드 환경에서 공유 자원 수정
    └── RunSyncronized.java         # 동기화 유무에 따른 결과 비교
```

## 🧵 Thread 학습 내용

### 기본 Thread 개념
- **Thread vs Runnable**: Thread 클래스 상속 vs Runnable 인터페이스 구현 방식 비교
- **Thread 생명주기**: 스레드 생성, 실행, 종료 과정
- **Daemon Thread**: 백그라운드에서 실행되는 데몬 스레드 설정

### Thread 동기화 (Synchronization)
- **Race Condition**: 멀티스레드 환경에서 발생하는 경쟁 상태 문제
- **synchronized 키워드**: 메서드 및 블록 레벨 동기화
- **객체 락 (Object Lock)**: 세밀한 동기화 제어를 위한 별도 락 객체 사용
- **성능 최적화**: 필요한 부분만 동기화하여 불필요한 대기 시간 최소화

## 🔧 개발 환경

- **Language**: Java
- **Build Tool**: Gradle
- **IDE**: IntelliJ IDEA (또는 Eclipse)
- **Docker**: 원격 디버깅 지원

## 🚀 실행 방법

```bash
# 프로젝트 빌드
./gradlew build

# 특정 클래스 실행 예시
java -cp build/classes/java/main org.thread.Main
java -cp build/classes/java/main org.thread.Syncronized.RunSyncronized
```

## 📚 학습 참고서

- 자바의 신 (God of Java)
- 기타 Java 관련 서적 및 온라인 자료

---

*이 프로젝트는 지속적으로 업데이트됩니다. 새로운 Java 개념을 학습할 때마다 예제 코드를 추가하고 문서를 갱신합니다.*
