## Blocking-free algorithms
1. Obstruction-free - поток совершает прогресс, если нет препятствий;
2. Lock-free - гарантируется системный прогресс хотя бы одного потока;
    - Много бесполезных циклов;
    - Сложнее поддерживать.
3. Wait-free - каждая операция выполняется за фиксированное число шагов.

CAS и FAA в Java:
- Scalars 
    - AtomicBoolean
    - AtomicInteger
    - AtomicLong
    - AtomicReference 
- Field Updaters
  - AtomicIntegerFieldUpdater
    - Reflection-based updater for volatile _int_
  - AtomicLongFieldUpdater
      - Reflection-based updater for volatile _long_
  - AtomicReferenceFieldUpdater
      - Reflection-based updater for volatile _object_
- Arrays
  - AtomicIntegerArray
  - AtomicLongArray
  - AtomicReferenceArray
- Compound Variables
  - AtomicMarkableReferences
  - AtomicStampedReferences
- Accumulators
  - DoubleAccumulator
  - DoubleAdder
  - LongAccumulator
  - LongAdder
  - Striped64

