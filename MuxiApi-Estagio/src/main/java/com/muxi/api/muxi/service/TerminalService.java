package com.muxi.api.muxi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.muxi.api.muxi.model.Terminal;

@Service
public class TerminalService {

    Map<Integer, Terminal> terminalmap = null;

    public boolean save(Terminal terminal) {
        if (terminalmap == null) {
            terminalmap = new HashMap<Integer, Terminal>();
        }
        terminalmap.put(terminal.getLogic(), terminal);
        return true;
    }

    public List<Terminal> findAll() {
        List<Terminal> terminais = new ArrayList<Terminal>(terminalmap.values());
        return terminais;
    }

    public Terminal findId(Integer logic) {
        Terminal terminal = terminalmap.get(logic);
        return terminal;
    }

    public boolean delete(Integer logic) {
        terminalmap.remove(logic);
        return true;
    }

    public Terminal update(Integer logic, Terminal terminal) {
        return terminalmap.replace(logic, terminal);
    }
}
