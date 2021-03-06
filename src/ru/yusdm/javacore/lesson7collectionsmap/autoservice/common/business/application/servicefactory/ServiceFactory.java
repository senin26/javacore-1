package ru.yusdm.javacore.lesson7collectionsmap.autoservice.common.business.application.servicefactory;

import ru.yusdm.javacore.lesson7collectionsmap.autoservice.mark.service.MarkService;
import ru.yusdm.javacore.lesson7collectionsmap.autoservice.model.service.ModelService;
import ru.yusdm.javacore.lesson7collectionsmap.autoservice.order.service.OrderService;
import ru.yusdm.javacore.lesson7collectionsmap.autoservice.user.service.UserService;

public interface ServiceFactory {
    MarkService getMarkService();
    ModelService getModelService();
    OrderService getOrderService();
    UserService getUserService();
}
