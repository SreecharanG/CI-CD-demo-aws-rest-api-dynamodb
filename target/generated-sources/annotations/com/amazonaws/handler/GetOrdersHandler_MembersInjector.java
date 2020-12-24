package com.amazonaws.handler;

import com.amazonaws.dao.OrderDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetOrdersHandler_MembersInjector implements MembersInjector<GetOrdersHandler> {
  private final Provider<ObjectMapper> objectMapperProvider;

  private final Provider<OrderDao> orderDaoProvider;

  public GetOrdersHandler_MembersInjector(
      Provider<ObjectMapper> objectMapperProvider, Provider<OrderDao> orderDaoProvider) {
    this.objectMapperProvider = objectMapperProvider;
    this.orderDaoProvider = orderDaoProvider;
  }

  public static MembersInjector<GetOrdersHandler> create(
      Provider<ObjectMapper> objectMapperProvider, Provider<OrderDao> orderDaoProvider) {
    return new GetOrdersHandler_MembersInjector(objectMapperProvider, orderDaoProvider);
  }

  @Override
  public void injectMembers(GetOrdersHandler instance) {
    injectObjectMapper(instance, objectMapperProvider.get());
    injectOrderDao(instance, orderDaoProvider.get());
  }

  public static void injectObjectMapper(GetOrdersHandler instance, ObjectMapper objectMapper) {
    instance.objectMapper = objectMapper;
  }

  public static void injectOrderDao(GetOrdersHandler instance, OrderDao orderDao) {
    instance.orderDao = orderDao;
  }
}
