-- 1. 직원 (Empl) 테이블 생성
CREATE TABLE Empl (
                      Employee_ID VARCHAR(20) PRIMARY KEY, -- 직원 고유 번호 (사번, 기본키)
                      Name VARCHAR(50) NOT NULL,           -- 직원 이름 (필수 입력)
                      Department VARCHAR(50),              -- 소속 부서
                      Contact VARCHAR(50)                  -- 연락처 또는 사내 메신저 ID
);

-- 2. 비품 (Supply) 테이블 생성
CREATE TABLE Supply (
                        Item_ID VARCHAR(20) PRIMARY KEY,     -- 비품 고유 번호 (기본키)
                        Item_Name VARCHAR(100) NOT NULL,     -- 비품명 (예: 케이블 타이, 벨크로 등)
                        Category VARCHAR(50),                -- 분류 (전선 정리용, 사무용품 등)
                        Stock INT DEFAULT 0                  -- 재고 수량 (기본값 0)
);

-- 3. 신청 내역 (Order_Request) 테이블 생성
CREATE TABLE Order_Request (
                               Order_ID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,          -- 신청 건 고유 번호 (기본키)
                               Employee_ID VARCHAR2(20),             -- 신청 직원 사번
                               Item_ID VARCHAR2(20),                 -- 신청 비품 번호
                               Request_Qty NUMBER NOT NULL,          -- 신청 수량 (필수 입력)
                               Order_Date DATE DEFAULT SYSDATE,      -- 신청 시간 (자동 입력)
                               Status VARCHAR2(20) DEFAULT '대기중' -- 진행 상태 (기본값 '대기중')
);