package com.epam.gem.logic;

import com.epam.gem.entity.Gem;
import com.epam.gem.exception.GemException;

import java.util.List;

public interface Parser {
    List<Gem> parse(String path) throws GemException;
}
