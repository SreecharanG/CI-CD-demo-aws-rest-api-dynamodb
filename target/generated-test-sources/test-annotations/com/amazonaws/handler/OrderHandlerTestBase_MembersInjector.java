package com.amazonaws.handler;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class OrderHandlerTestBase_MembersInjector
    implements MembersInjector<OrderHandlerTestBase> {
  private final Provider<DynamoDbClient> dynamoDbProvider;

  public OrderHandlerTestBase_MembersInjector(Provider<DynamoDbClient> dynamoDbProvider) {
    this.dynamoDbProvider = dynamoDbProvider;
  }

  public static MembersInjector<OrderHandlerTestBase> create(
      Provider<DynamoDbClient> dynamoDbProvider) {
    return new OrderHandlerTestBase_MembersInjector(dynamoDbProvider);
  }

  @Override
  public void injectMembers(OrderHandlerTestBase instance) {
    injectDynamoDb(instance, dynamoDbProvider.get());
  }

  public static void injectDynamoDb(OrderHandlerTestBase instance, DynamoDbClient dynamoDb) {
    instance.dynamoDb = dynamoDb;
  }
}
