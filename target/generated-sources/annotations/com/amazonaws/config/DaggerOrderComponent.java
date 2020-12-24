package com.amazonaws.config;

import com.amazonaws.dao.OrderDao;
import com.amazonaws.handler.CreateOrderHandler;
import com.amazonaws.handler.CreateOrderHandler_MembersInjector;
import com.amazonaws.handler.DeleteOrderHandler;
import com.amazonaws.handler.DeleteOrderHandler_MembersInjector;
import com.amazonaws.handler.GetOrderHandler;
import com.amazonaws.handler.GetOrderHandler_MembersInjector;
import com.amazonaws.handler.GetOrdersHandler;
import com.amazonaws.handler.GetOrdersHandler_MembersInjector;
import com.amazonaws.handler.UpdateOrderHandler;
import com.amazonaws.handler.UpdateOrderHandler_MembersInjector;
import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerOrderComponent implements OrderComponent {
  private Provider<ObjectMapper> objectMapperProvider;

  private Provider<DynamoDbClient> dynamoDbProvider;

  private Provider<String> tableNameProvider;

  private Provider<OrderDao> orderDaoProvider;

  private DaggerOrderComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static OrderComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.objectMapperProvider =
        DoubleCheck.provider(OrderModule_ObjectMapperFactory.create(builder.orderModule));
    this.dynamoDbProvider =
        DoubleCheck.provider(OrderModule_DynamoDbFactory.create(builder.orderModule));
    this.tableNameProvider =
        DoubleCheck.provider(OrderModule_TableNameFactory.create(builder.orderModule));
    this.orderDaoProvider =
        DoubleCheck.provider(
            OrderModule_OrderDaoFactory.create(
                builder.orderModule, dynamoDbProvider, tableNameProvider));
  }

  @Override
  public void inject(CreateOrderHandler requestHandler) {
    injectCreateOrderHandler(requestHandler);
  }

  @Override
  public void inject(DeleteOrderHandler requestHandler) {
    injectDeleteOrderHandler(requestHandler);
  }

  @Override
  public void inject(GetOrderHandler requestHandler) {
    injectGetOrderHandler(requestHandler);
  }

  @Override
  public void inject(GetOrdersHandler requestHandler) {
    injectGetOrdersHandler(requestHandler);
  }

  @Override
  public void inject(UpdateOrderHandler requestHandler) {
    injectUpdateOrderHandler(requestHandler);
  }

  private CreateOrderHandler injectCreateOrderHandler(CreateOrderHandler instance) {
    CreateOrderHandler_MembersInjector.injectObjectMapper(instance, objectMapperProvider.get());
    CreateOrderHandler_MembersInjector.injectOrderDao(instance, orderDaoProvider.get());
    return instance;
  }

  private DeleteOrderHandler injectDeleteOrderHandler(DeleteOrderHandler instance) {
    DeleteOrderHandler_MembersInjector.injectObjectMapper(instance, objectMapperProvider.get());
    DeleteOrderHandler_MembersInjector.injectOrderDao(instance, orderDaoProvider.get());
    return instance;
  }

  private GetOrderHandler injectGetOrderHandler(GetOrderHandler instance) {
    GetOrderHandler_MembersInjector.injectObjectMapper(instance, objectMapperProvider.get());
    GetOrderHandler_MembersInjector.injectOrderDao(instance, orderDaoProvider.get());
    return instance;
  }

  private GetOrdersHandler injectGetOrdersHandler(GetOrdersHandler instance) {
    GetOrdersHandler_MembersInjector.injectObjectMapper(instance, objectMapperProvider.get());
    GetOrdersHandler_MembersInjector.injectOrderDao(instance, orderDaoProvider.get());
    return instance;
  }

  private UpdateOrderHandler injectUpdateOrderHandler(UpdateOrderHandler instance) {
    UpdateOrderHandler_MembersInjector.injectObjectMapper(instance, objectMapperProvider.get());
    UpdateOrderHandler_MembersInjector.injectOrderDao(instance, orderDaoProvider.get());
    return instance;
  }

  public static final class Builder {
    private OrderModule orderModule;

    private Builder() {}

    public OrderComponent build() {
      if (orderModule == null) {
        this.orderModule = new OrderModule();
      }
      return new DaggerOrderComponent(this);
    }

    public Builder orderModule(OrderModule orderModule) {
      this.orderModule = Preconditions.checkNotNull(orderModule);
      return this;
    }
  }
}
