package org.softuni.pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.softuni.pathfinder.model.entity.Picture;
import org.softuni.pathfinder.model.view.RouteViewModel;
import org.softuni.pathfinder.repository.RouteRepository;
import org.softuni.pathfinder.service.RouteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;

    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<RouteViewModel> findAllRoutes() {
        return routeRepository.findAll().stream()
                .map(route -> {
                    RouteViewModel routeViewModel = modelMapper.map(route,RouteViewModel.class);
                   routeViewModel.setPictureUrl(route.getPictures().stream()
                            .map(Picture::getUrl)
                            .findAny().orElse("/images/pic4.jpg"));
                   return routeViewModel;
                }).toList();
    }
}
