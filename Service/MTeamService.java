package com.Apex.ApexApproval.Service;

import com.Apex.ApexApproval.Model.Dean;
import com.Apex.ApexApproval.Model.MTeam;
import com.Apex.ApexApproval.Repository.MTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MTeamService {
    @Autowired
    MTeamRepository mTeamRepository;
    public void addRequest(MTeam mTeam) {
        mTeamRepository.save(mTeam);
    }

    public List<MTeam> showAll() {
        return mTeamRepository.findAll();
    }
    public void update(int id, Boolean approvalStatus) {
        Optional<MTeam> optionalMTeam = mTeamRepository.findById(id);

        if (optionalMTeam.isPresent()) {
            MTeam mTeam = optionalMTeam.get();
            mTeam.setApproved(approvalStatus);
            mTeamRepository.save(mTeam);
        } else {
            System.out.println("Principal with id " + id + " not found.");
        }
    }
}
