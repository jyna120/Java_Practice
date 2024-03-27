package com.jy.member.repository;

import com.jy.member.model.vo.Member;

// 포인트관리시스템 실습문제3
public class MemberRepository {
    private static final int MAX_MEMBER = 40;
    private Member members[] = new Member[MAX_MEMBER];
    private int index = 0;

    public void insertMember(Member m) {
//        members[index++] = new Member(m.getName(), m.getGrade(), m.getPoint());   // 추상클래스는 객체화 불가
        this.members[index++] = m;
    }

    public void printData() {
        String inform = """
        ----------------------   정보출력   ------------------------
        이름              등급              포인트             이자포인트
        """;

        System.out.print(inform);

        for(int i=0; i<index; i++) {
            Member m = members[i];
            System.out.printf("%s%17s%17d%17.2f\n", m.getName(), m.getGrade(), m.getPoint(), m.getEjapoint());
        }
        System.out.println("-----------------------------------------------------------");
    }

    public void printBuyInfo(int price) {
        for(int i=0; i<index; i++) {
            Member m = members[i];
            System.out.printf("%s등급회원 %s는 %d원 상품을 %d원에 구매합니다.\n", m.getGrade(), m.getName(), price, m.buy(price));
        }
        System.out.println("-----------------------------------------------------------");
    }
}
