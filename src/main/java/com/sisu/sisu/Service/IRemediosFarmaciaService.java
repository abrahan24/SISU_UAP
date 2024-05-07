package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sisu.sisu.entitys.RemediosFarmacia;

@Service
public interface IRemediosFarmaciaService {
    public List<RemediosFarmacia> findAll();
    public void save(RemediosFarmacia remediosFarmacia);
    public RemediosFarmacia findOne(Integer id);
    public void delete(Integer id);
}
