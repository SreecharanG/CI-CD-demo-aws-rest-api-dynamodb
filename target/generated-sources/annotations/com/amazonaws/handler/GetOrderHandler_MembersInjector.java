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
public final class GetOrderHandler_MembersInjector implements MembersInjector<GetOrderHandler> {
  private final Provider<ObjectMapper> objectMapperProvider;

  private final Provider<OrderDao> orderDaoProvider;

  public GetOrderHandler_MembersInjector(
      Provider<ObjectMapper> objectMapperProvider, Provider<OrderDao> orderDaoProvider) {
    this.objectMapperProvider = objectMapperProvider;
    this.orderDaoProvider = orderDaoProvider;
  }

  public static MembersInjector<GetOrderHandler> create(
      Provider<ObjectMapper> objectMapperProvider, Provider<OrderDao> orderDaoProvider) {
    return new GetOrderHandler_MembersInjector(objectMapperProvider, orderDaoProvider);
  }

  @Override
  public void injectMembers(GetOrderHandler instance) {
    injectObjectMapper(instance, objectMapperProvider.get());
    injectOrderDao(instance, orderDaoProvider.get());
  }

  public static void injectObjectMapper(GetOrderHandler instance, ObjectMapper objectMapper) {
    instance.objectMapper = objectMapper;
  }

  public static void injectOrderDao(GetOrderHandler instance, OrderDao orderDao) {
    instance.orderDao = orderDao;
  }
}
