package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sisu.sisu.entitys.RemediosFarmaciaLote;

@Service
public interface IRemediosFarmaciaLoteService {
    public List<RemediosFarmaciaLote> findAll();
    public void save(RemediosFarmaciaLote remediosFarmaciaLote);
    public RemediosFarmaciaLote findOne(Integer id);
    public void delete(Integer id);
}
