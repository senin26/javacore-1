package ru.yusdm.javacore.lesson9genericsbegin.autoservice.common.business.repo;

import ru.yusdm.javacore.lesson9genericsbegin.autoservice.common.solutions.repo.BaseRepo;

/**
 * Created by Admin on 3/11/2019.
 */
public interface CommonCrud<TYPE, ID, TYPE_SEARCH_CONDITION> extends BaseRepo {
}
