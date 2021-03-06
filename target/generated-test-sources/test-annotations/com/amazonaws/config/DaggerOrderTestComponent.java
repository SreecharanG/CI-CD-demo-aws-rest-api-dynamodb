package com.amazonaws.config;

import com.amazonaws.dao.OrderDao;
import com.amazonaws.handler.OrderHandlerTestBase;
import com.amazonaws.handler.OrderHandlerTestBase_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerOrderTestComponent implements OrderTestComponent {
  private Provider<DynamoDbClient> dynamoDbProvider;

  private Provider<String> tableNameProvider;

  private Provider<OrderDao> orderDaoProvider;

  private DaggerOrderTestComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static OrderTestComponent create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
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
  public OrderDao provideOrderDao() {
    return orderDaoProvider.get();
  }

  @Override
  public void inject(OrderHandlerTestBase integrationTest) {
    injectOrderHandlerTestBase(integrationTest);
  }

  private OrderHandlerTestBase injectOrderHandlerTestBase(OrderHandlerTestBase instance) {
    OrderHandlerTestBase_MembersInjector.injectDynamoDb(instance, dynamoDbProvider.get());
    return instance;
  }

  public static final class Builder {
    private OrderModule orderModule;

    private Builder() {}

    public OrderTestComponent build() {
      if (orderModule == null) {
        this.orderModule = new OrderModule();
      }
      return new DaggerOrderTestComponent(this);
    }

    public Builder orderModule(OrderModule orderModule) {
      this.orderModule = Preconditions.checkNotNull(orderModule);
      return this;
    }
  }
}
