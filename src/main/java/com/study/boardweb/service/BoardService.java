package com.study.boardweb.service;

import com.study.boardweb.entity.Board;
import com.study.boardweb.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    @Autowired // 자동 객체 생성
    private final BoardRepository boardRepository;


    // 글 작성 처리
    @Transactional
    public void write(Board board){

        boardRepository.save(board);
    }


    // 게시글 리스트 처리
    @Transactional
    public Page<Board> boardList(Pageable pageable){

        return boardRepository.findAll(pageable);

    }

    // 특정 게시글 불러오기
    @Transactional
    public Board boardView(Integer id){


        return boardRepository.findById(id).get();
    }

    // 특정 게시글 삭제
    // void -> 리턴이 없을 떄
    public void boardDelete(Integer id){

        boardRepository.deleteById(id);


    }


}
