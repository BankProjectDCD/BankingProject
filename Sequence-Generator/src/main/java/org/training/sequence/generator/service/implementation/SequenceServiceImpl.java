package org.training.sequence.generator.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.function.LongPredicate;

import org.springframework.stereotype.Service;
import org.training.sequence.generator.model.entity.Sequence;
import org.training.sequence.generator.reporitory.SequenceRepository;
import org.training.sequence.generator.service.SequenceService;

@Slf4j
@Service
@RequiredArgsConstructor
public class SequenceServiceImpl implements SequenceService {

    private final SequenceRepository sequenceRepository = null;

    /**
     * Create a new account number.
     *
     * @return The newly created account number.
     */
    @Override
    public Sequence create() {
        System.out.println("Creating an account number");
        return sequenceRepository.findById(1L)
                .map(sequence -> {
                    sequence.setAccountNumber(sequence.getAccountNumber() + 1);
                    return sequenceRepository.save(sequence);
                })
                .orElseGet(() -> {
                    Sequence newSequence = Sequence.builder()
                            .withAccountNumber(1L)
                            .build();
                    return sequenceRepository.save(newSequence);
                });
    }
}