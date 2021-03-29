package manafov;

import java.math.BigDecimal;

public interface Operation {
    BigDecimal calculate(BigDecimal operandLeft, BigDecimal operandRight);
}
