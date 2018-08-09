/*
 * Copyright (C) 2018 Perin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.feevale.jpe.core;

import br.feevale.jpe.model.Person;
import br.feevale.jpe.core.utils.Files;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple Application
 *
 * @author joaovperin
 */
public class SimpleApplication implements Application {

    /**
     * Doesn't need any configuration
     *
     * @param args
     * @return Application
     */
    @Override
    public SimpleApplication config(String[] args) {
        return this;
    }

    /**
     * Runs the app
     *
     * @throws ApplicationException
     */
    @Override
    public void run() throws ApplicationException {
        System.out.println("**** Start");
        List<Person> list = new ArrayList<>();
        // Reads from file
        try {
            final String src = "res/pessoas.txt";
            list.addAll(Files.read(src, Person.class));
        } catch (IOException ex) {
            throw new ApplicationException(ex);
        }
        // Sort and print
        list.sort(Person::compareTo);
        list.forEach(System.out::println);
        System.out.println("**** End :D");
    }

}
