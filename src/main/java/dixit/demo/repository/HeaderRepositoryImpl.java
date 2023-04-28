package dixit.demo.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HeaderRepositoryImpl implements HeaderRepositoryCustom {

    private final JPAQueryFactory queryFactory;






}
