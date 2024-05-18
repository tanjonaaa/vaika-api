package com.vaika.api.concurrency;

import static com.vaika.api.concurrency.ThreadRenamer.getRandomSubThreadNamePrefixFrom;
import static com.vaika.api.concurrency.ThreadRenamer.renameThread;
import static java.lang.Thread.currentThread;
import static java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor;

import com.vaika.api.PojaGenerated;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@PojaGenerated
@Component
public class Workers<T> {
  private final ExecutorService executorService;

  public Workers() {
    this.executorService = newVirtualThreadPerTaskExecutor();
  }

  @SneakyThrows
  public List<Future<T>> invokeAll(List<Callable<T>> callables) {
    var parentThread = currentThread();
    callables =
        callables.stream()
            .map(
                c ->
                    (Callable<T>)
                        () -> {
                          renameThread(
                              currentThread(), getRandomSubThreadNamePrefixFrom(parentThread));
                          return c.call();
                        })
            .toList();
    return executorService.invokeAll(callables);
  }
}
