package dixit.demo.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dixit.demo.domain.QLeftPost;
import dixit.demo.domain.QPost;
import dixit.demo.dto.FindPostDto;
import lombok.RequiredArgsConstructor;

import static dixit.demo.domain.QLeftPost.*;
import static dixit.demo.domain.QPost.*;

@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom {

    private final JPAQueryFactory queryFactory;




}
