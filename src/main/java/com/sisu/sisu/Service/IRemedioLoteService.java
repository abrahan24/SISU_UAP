package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sisu.sisu.entitys.RemedioLote;

@Service
public interface IRemedioLoteService {
    public List<RemedioLote> findAll();
    public void save(RemedioLote remedioLote);
    public RemedioLote findOne(Integer id);
    public void delete(Integer id);
}
